from django.conf.urls import url
from user_account import views

urlpatterns = [
    url('^useracc/', views.useracc),
    url(r'^android/', views.Useraccountview.as_view()),
    url(r'^android11/', views.withdraw.as_view()),
    url(r'^android1/', views.Accc.as_view()),
]