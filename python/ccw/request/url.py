from django.conf.urls import url
from request import views

urlpatterns = [
    url('^req/',views.viewrequest),
    url(r'^android/', views.Requestview.as_view()),
    url('^rapprove/(?P<idd>\w+)', views.approve, name='rapprove'),
    url('^rreject/(?P<idd>\w+)', views.reject, name='rreject'),
]