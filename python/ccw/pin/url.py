from django.conf.urls import url
from pin import views
urlpatterns=[
    url(r'^android/', views.Pinview.as_view()),

]


