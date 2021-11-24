from django.conf.urls import url
from reply import views
urlpatterns = [
    url('^reply/', views.reply),
    url(r'^android/', views.Replyview.as_view()),
]