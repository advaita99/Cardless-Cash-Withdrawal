from django.conf.urls import url
from feedback import views

urlpatterns=[
    url('^feedb/',views.feedback),
    url(r'^android/', views.Feedbackview.as_view()),
]