"""ccw URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/3.0/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.conf.urls import url, include
from django.contrib.staticfiles.urls import staticfiles_urlpatterns
from login import views


urlpatterns = [

    # url('^login/',include('login.url')),
    url('^admin_complaint/',include('admin_complaint.url')),
    url('^atm_refill/',include('atm_refill.url')),
    url('^request/',include('request.url')),
    url('^atm_transaction/',include('atm_transactions.url')),
    url('^bank/', include('bank.url')),
    url('^complaint/', include('complaint.url')),
    url('^feedback/', include('feedback.url')),
    url('^login/', include('login.url')),
    url('^pin/', include('pin.url')),
    url('^qr/', include('qr.url')),
    url('^rating/', include('rating.url')),
    url('^reply/', include('reply.url')),
    url('^reply_to_bank/', include('reply_to_bank.url')),
    url('^user/', include('user.url')),
    url('^userac/', include('user_account.url')),
    url('^atmreg/',include('atm.url')),
    url('^$',views.login)
]

urlpatterns+=staticfiles_urlpatterns()