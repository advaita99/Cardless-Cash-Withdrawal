from django.conf.urls import url
from login import views

urlpatterns=[
    url('^login/',views.login),
    url(r'^android/', views.Loginview.as_view()),
    url('forgot/', views.frgtpwd),
]