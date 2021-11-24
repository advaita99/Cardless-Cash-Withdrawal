from django.conf.urls import url
from atm_transactions import views

urlpatterns=[
    url('^atmtrans/',views.atmtrans),
    url(r'^android/', views.Atmtransactionview.as_view()),
]
