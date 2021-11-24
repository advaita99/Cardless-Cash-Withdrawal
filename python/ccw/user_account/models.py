from django.db import models

# Create your models here.
class UserAccount(models.Model):
    ua_id = models.AutoField(primary_key=True)
    u_id = models.IntegerField()
    account_number = models.CharField(max_length=25)
    ifsc_code = models.CharField(max_length=25)
    type_of_account = models.CharField(max_length=25)
    balance = models.CharField(max_length=10)

    class Meta:
        managed = False
        db_table = 'user_account'

