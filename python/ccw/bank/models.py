from django.db import models

# Create your models here.

class Bank(models.Model):
    b_id = models.AutoField(primary_key=True)
    l_id = models.IntegerField()
    bank_name = models.CharField(max_length=25)
    address = models.CharField(max_length=50)
    reg_no = models.CharField(max_length=20)
    ifsc_code = models.CharField(max_length=20)
    email = models.CharField(max_length=25)
    phone_number = models.CharField(max_length=10)
    status = models.CharField(max_length=100)

    class Meta:
        managed = False
        db_table = 'bank'
