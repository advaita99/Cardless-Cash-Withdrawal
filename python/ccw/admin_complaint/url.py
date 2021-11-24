from django.conf.urls import url
from admin_complaint import views

urlpatterns = [
    url('^pcomp/',views.postcomp),
    url('^vwcomp/',views.viewcomplaint),
    url('^breply/(?P<idd>\w+)', views.bankpostreply, name='breply'),

]
