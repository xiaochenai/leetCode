#!/usr/bin/env python
# coding: utf-8

import os, sys
import re
import urllib2
import threading
import Queue

host = '' #host
base_url = '' #base url need append the number/index of page

START_PAGE = 2
END_PAGE = 2
LEAST_REPLIES = 200
PAGE_PATTERN = re.compile(r'<tr.+?<h3>.+?href="(.+?)".+?>([^<.+?>].+?)<.+? f10 y-style">(\d+)<', re.DOTALL)
IMG_URL_PATTERN = re.compile(r'<br><input .+?src=[\'"](.+?)[\'"]')

class ImgThread(threading.Thread):
    """Threaded image url grabs"""
    def __init__(self, img_pattern, page_queue, img_queue):
        threading.Thread.__init__(self)
        self.img_pattern = img_pattern
        self.page_queue = page_queue
        self.img_queue = img_queue

    def run(self):
        while True:
            url_tuple = self.page_queue.get()
            url, title = url_tuple
            try:
                html = urllib2.urlopen(url).read()
            except Exception, e:
                print u'**ERROR**: %s : %s\t--IGNORE--' % (url, e)

            img_urls = self.img_pattern.findall(html)
            if img_urls:
                self.img_queue.put((img_urls, title))

            self.page_queue.task_done()

class Downloader(threading.Thread):
    """Threaded file downloader"""
    def __init__(self, img_queue):
        threading.Thread.__init__(self)
        self.img_queue = img_queue

    def run(self):
        while True:
            url_tuple = self.img_queue.get()
            urls, title = url_tuple
            title = title.decode('gb2312', 'ignore')
            title = '.'.join(title.split('/'))
            try:
                os.makedirs(title)
            except OSError:
                print '**Can not create directory: %s\t--IGNORE--' % title
                self.img_queue.task_done()
                continue
            for url in urls:
                try:
                    handle = urllib2.urlopen(url)
                except Exception, e:
                    print u'**ERROR**: %s : %s\t--IGNORE--' % (url, e)
                    continue
                fname = os.path.basename(url)
                print 'Downloading %s, Saving to %s' % (url, title)
                with open('%s/%s' % (title, fname), 'wb') as f:
                    while True:
                        chunk = handle.read(1024)
                        if not chunk:
                            break
                        f.write(chunk)

            self.img_queue.task_done()

def put_page(page_queue, pattern, url):
    """Parse the given url by given pattern, put matched pages in page_queue."""
    try:
        html = urllib2.urlopen(url).read()
    except Exception, e:
        print u'**ERROR**: %s : %s\t--IGNORE--' % (url, e)
    values = pattern.findall(html)
    
    if values:
        # this line gets pages we want :)
        filtered = [i[:2] for i in values if int(i[2]) >= LEAST_REPLIES]
        for url, title in filtered:
            print url
            print title
            if not url.startswith('http://'):
                url = host + url
            page_queue.put((url, title))
def single_download(uRL):
    html = urllib2.urlopen(uRL).read()
    pattern = re.compile(r'<title>[\s\S]*?</title>')
    title = pattern.findall(html)
    title =  title[0].strip("</title>")
    title = title.decode('gb2312', 'ignore')
    title = '.'.join(title.split('/'))
    img_pattern  = re.compile(r'<br><input .+?src=[\'"](.+?)[\'"]')
    img_urls = img_pattern.findall(html)
    print img_urls
    if len(img_urls) == 0:
        img_pattern  = re.compile(r'<br><img .+?src=[\'"](.+?)[\'"]')
        img_urls = img_pattern.findall(html)
        print img_urls
    img_queue = Queue.Queue()
    if img_urls:
        img_queue.put((img_urls, title))
    url_tuple = img_queue.get()
    urls, title = url_tuple
    title = '.'.join(title.split('/'))
    try:
        os.makedirs(title)
    except OSError:
        print '**Can not create directory: %s\t--IGNORE--' % title
    for url in urls:
        try:
            handle = urllib2.urlopen(url)
        except Exception, e:
            print u'**ERROR**: %s : %s\t--IGNORE--' % (url, e)
            continue
        fname = os.path.basename(url)
        print 'Downloading %s, Saving to %s' % (url, title)
        with open('%s/%s' % (title, fname), 'wb') as f:
            while True:
                chunk = handle.read(1024)
                if not chunk:
                    break
                f.write(chunk)
    
def work():
    """main function."""
    assert(START_PAGE <= END_PAGE), "START_PAGE must be less or equal to END_PAGE!"

    print '{:<20}'.format('Start page:'), START_PAGE
    print '{:<20}'.format('End page:'), END_PAGE
    print '{:<20}'.format('Least replies:'), LEAST_REPLIES
    print '-'*100

    page_queue = Queue.Queue()
    img_queue = Queue.Queue()

    for i in range(START_PAGE, END_PAGE+1):
        url = base_url + str(i)
        put_page(page_queue, PAGE_PATTERN, url)

    for i in range(10):
        img_t = ImgThread(IMG_URL_PATTERN, page_queue, img_queue)
        img_t.daemon = True
        img_t.start()

    for i in range(10):
        d_t = Downloader(img_queue)
        d_t.daemon = True
        d_t.start()

    page_queue.join()
    img_queue.join()
    print '-'*100
    print "Done."

if __name__ == '__main__':
    single_download('enter url here')
