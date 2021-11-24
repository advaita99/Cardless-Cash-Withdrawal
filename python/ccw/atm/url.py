from django.conf.urls import url
from atm import views

urlpatterns=[
    url('^atmreg',views.regatm),
    url('vwatm',views.viewatm),
    url('manageatm',views.manageatm),
    url('^update/(?P<idd>\w+)',views.update, name='update'),
    url('^block/(?P<idd>\w+)', views.block, name='block'),
    url(r'^android/', views.Atmview.as_view()),
]
