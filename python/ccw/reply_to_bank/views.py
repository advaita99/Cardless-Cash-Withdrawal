from django.shortcuts import render
from reply_to_bank.models import ReplyToBank
import datetime

def replybank(request,idd):
    # if request.method == "POST":
    #     obj=ReplyToBank()
    #     obj.ca_id = idd
    #     obj.reply=request.POST.get("reply")
    #     obj.date = datetime.date.today()
    #     obj.time = datetime.datetime.now()
    #     obj.save()

    return render(request,'reply_to_bank/postreply.html')
