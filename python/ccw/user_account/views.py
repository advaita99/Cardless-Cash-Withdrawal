from django.shortcuts import render
from user_account.models import UserAccount
from atm.models import Atm
from user.models import User
from pin.models import Pin
from atm_transactions.models import AtmTransactions
import datetime


def useracc(request):
    obj = UserAccount.objects.all()
    context= {
        'objval':obj,
    }
    return render(request,'user_account/user_account_details.html',context)


from .serializer import Android_serializer
from rest_framework.views import APIView,Response
from django.http import HttpResponse
from login.models import Login

class Useraccountview(APIView):

    def get(self,request):
        s=UserAccount.objects.all()
        ser=Android_serializer(s,many=True)
        return Response(ser.data)


    def post(self, request):
        obj = UserAccount()
        obj.u_id =request.data["u_id"]
        obj.account_number = request.data["account_number"]
        obj.ifsc_code = request.data["ifsc_code"]
        obj.type_of_account = request.data["type_of_account"]
        obj.balance= request.data["balance"]
        obj.save()

        return HttpResponse("ok")



class withdraw(APIView):
    def post(self, request):

        uid = request.data["uid"]
        aid = request.data["aid"]
        pin = request.data["pin"]
        amt = request.data["amt"]
        acc = request.data["acc"]

        if Atm.objects.filter(atm_id=aid).exists():
            print('atm found')
            if UserAccount.objects.filter(ua_id=acc).exists():
                print('user acc found')
                obj = UserAccount.objects.get(ua_id=acc)
                ba = obj.balance
                account = obj.account_number
                print(ba)

                ob = Pin.objects.get(account_number=account)
                pi = ob.pin

                if pin == pi:
                    print('pin match')

                    ba = int(ba)
                    amt = int(amt)

                    tot = ba-amt
                    print(tot)

                    if tot>0:
                        print('amt reduc')
                        obj.balance = tot
                        obj.save()

                        ooo = AtmTransactions()
                        ooo.atm_id = aid
                        ooo.u_id = uid
                        ooo.ifsc_code = obj.ifsc_code
                        ooo.account_number = account
                        ooo.date = datetime.date.today()
                        ooo.time =datetime.datetime.now().time()
                        ooo.status = 'withdraw'
                        ooo.amount = amt
                        ooo.save()

                        return HttpResponse("Withdraw Success...")
                    else:
                        return HttpResponse('No balace Found In Your Acc, Only '+str(ba)+ " Rs Found...")

                else:
                    return HttpResponse("PIN not matched...!")
            else:
                return HttpResponse("No bank Account Found...!")
        else:
            return HttpResponse("No ATM Found, Check QR Code")


class Accc(APIView):
    def post(self, request):
        uid = request.data["uid"]
        print(uid)
        s = UserAccount.objects.filter(u_id=uid)
        print(len(s))
        ser = Android_serializer(s, many=True)
        return Response(ser.data)
