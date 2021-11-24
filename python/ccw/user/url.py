from django.conf.urls import url
from user import views

urlpatterns = [
    url('^user/', views.user),
    url('^uaccept/(?P<idd>\w+)',views.uaccept, name='uaccept'),
    url('^ureject/(?P<idd>\w+)',views.ureject, name='ureject'),
    url(r'^android/', views.Userview.as_view()),
]
