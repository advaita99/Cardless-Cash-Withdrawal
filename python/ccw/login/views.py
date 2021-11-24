from django.shortcuts import render
from login.models import Login


def login(request):
    if request.method == "POST":
        uname = request.POST.get('nam')
        passw = request.POST.get('password')
        obj = Login.objects.filter(usename=uname,password=passw)
        tp = ""
        for ob in obj:
            tp = ob.type
            uid = ob.l_id
            if tp == "admin":
                request.session['uid'] = uid
                return render(request, 'temp/admin.html')
            elif tp == "bank":
                request.session['uid'] = uid
                return render(request, 'temp/bank.html')
            # elif tp == "subadmin":
            #     request.session["uid"] = uid
            #     return render(request, 'login/s_subhome.html')
            # else:
        objlist = "Username or Password incorrect... Please try again...!"
        context = {
            'msg': objlist,
        }
        return render(request, 'login/login.html', context)
    return render(request,'login/login.html')



from django.core.mail import send_mail
from bank.models import Bank
def frgtpwd(request):
    if request.method == "POST":
        uname = request.POST.get("nam")
        print(uname)
        try:
            ob = Login.objects.get(usename=uname)
            uid = ob.u_id
            pa = ob.password
            ty=ob.type
            print(uid)
            print(pa)

            print('test')
            print(ty)
            if ty == "bank":
                print('bank')
                obj = Bank.objects.filter(b_id=uid)
                print(len(obj))
                for x in obj:
                    em = x.email
                    send_mail('Cardless cashwithdrawal',
                              'Hi ' + uname + ' Your Forgotten password is..:' + " " + pa,
                              'sendmail.project009@gmail.com',
                              [em],
                              fail_silently=True)

            objlist = "Password send to your email address... Check your mail."
            context = {
                'msg': objlist
            }
            return render(request, 'login/forgot.html', context)


        except:
            print("false")

    return render(request,'login/forgot.html')







from .serializer import Android_serializer
from rest_framework.views import APIView,Response

class Loginview(APIView):

    def get(self,request):
        s=Login.objects.all()
        ser=Android_serializer(s,many=True)
        return Response(ser.data)

    def post(self,request):
        unm=request.data['unm']
        pswd=request.data['pswd']
        ob=Login.objects.filter(usename=unm,password=pswd)
        ser=Android_serializer(ob,many=True)
        return Response(ser.data)

