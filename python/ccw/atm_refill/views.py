from django.shortcuts import render
from atm_refill.models import AtmRefill
def atmrefil(request):
    obj=AtmRefill.objects.all()
    context ={
        'objval':obj,
    }
    return render(request,'atm_refill/view_balance&add_cash.html',context)
