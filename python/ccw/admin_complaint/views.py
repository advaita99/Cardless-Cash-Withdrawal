import datetime

from django.shortcuts import render
from admin_complaint.models import AdminComplaint
from reply_to_bank.models import ReplyToBank
def postcomp(request):
    if request.method == "POST":
        obj = AdminComplaint()
        obj.complaint=request.POST.get("complaint")
        obj.date=datetime.date.today()
        obj.time=datetime.datetime.now()

        obj.b_id=1
        obj.save()

    return render(request,'admin_complaint/post_complaint_to_admin.html')

def viewcomplaint(request):
    obj = AdminComplaint.objects.all()
    context = {
        'objval':obj,
    }
    return render(request,'admin_complaint/view_complaint_from_bank.html',context)



from reply_to_bank.models import ReplyToBank
import datetime
def bankpostreply(request,idd):
    obj = AdminComplaint.objects.get(ca_id=idd)
    context = {
        'objval': obj,
    }
    if request.method=="POST":
        obj=AdminComplaint.objects.get(ca_id=idd)
        obj.status="replied"
        obj.save()

    if request.method=="POST":
        ob=ReplyToBank()
        ob.ca_id=obj.ca_id
        ob.date=datetime.datetime.today()
        ob.time=datetime.datetime.now().time()
        ob.reply=request.POST.get("reply")
        ob.save()
        return viewcomplaint(request)
    return render(request, 'admin_complaint/bank_postreply.html', context)
