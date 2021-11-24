from django.db import models

# Create your models here.
class Pin(models.Model):
    pin_id = models.AutoField(primary_key=True)
    u_id = models.IntegerField()
    account_number = models.CharField(max_length=25)
    pin = models.CharField(max_length=25)
    status = models.CharField(max_length=25)

    class Meta:
        managed = False
        db_table = 'pin'
