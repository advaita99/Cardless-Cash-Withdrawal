from django.conf.urls import url
from complaint import views

urlpatterns=[
    url('^comp/',views.comp),
    url(r'^android/', views.Complaintrview.as_view()),
    url('^reply/(?P<idd>\w+)', views.postreply, name='reply'),
]