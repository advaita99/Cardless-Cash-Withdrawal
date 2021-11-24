from django.conf.urls import url
from atm_refill import views
urlpatterns=[
    url('^viewblnc/',views.atmrefil),
]