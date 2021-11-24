from django.conf.urls import url
from reply_to_bank import views
urlpatterns = [
    url('^replybnk/(?P<idd>\w+)', views.replybank,name='replybank'),
]