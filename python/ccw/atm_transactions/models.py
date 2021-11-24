from django.db import models

# Create your models here.

class AtmTransactions(models.Model):
    atmtr_id = models.AutoField(primary_key=True)
    atm_id = models.IntegerField()
    u_id = models.IntegerField()
    ifsc_code = models.CharField(max_length=25)
    account_number = models.CharField(max_length=105)
    date = models.DateField()
    time = models.TimeField()
    amount = models.CharField(max_length=25)
    status = models.CharField(max_length=25)

    class Meta:
        managed = False
        db_table = 'atm_transactions'

