const r = new Router (
    {
        '#default': new Page('frontPage.html'),
        frontPage: new Layout(new Page('frontPage.html')),
        news: new Layout(new Page('news.html')),
        aboutUs: new Layout(new Page('aboutUs.html')),
        contactUs: new Layout(new Page('contactUs.html')),
        myAccount: new Layout(new Page('myAccount.html')),
        viewRooms: new Layout(new Page('viewRooms.html')),
        myInbox: new Layout(new Page('myInbox.html')),
        submitTicket: new Layout(new Page('submitTicket.html'))
    },
    document.querySelector('main')
)