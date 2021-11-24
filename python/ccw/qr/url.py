from django.conf.urls import url
from qr import views
urlpatterns = [
    url(r'^android/', views.Qrview.as_view()),

]

