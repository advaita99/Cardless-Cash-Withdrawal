from django.conf.urls import url
from rating import views

urlpatterns = [
    url('^rate/', views.rating),
    url(r'^android/', views.Ratingview.as_view()),
]
