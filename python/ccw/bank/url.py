from django.conf.urls import url
from bank import views

urlpatterns = [
    url('^bankreg/',views.bank),
    url('^managebank/',views.managebank),
    url('^approve/(?P<idd>\w+)',views.approve, name='approve'),
    url('^reject/(?P<idd>\w+)',views.reject, name='reject'),
    url(r'^android/', views.Bankview.as_view()),
]
