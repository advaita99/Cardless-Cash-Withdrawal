from django.db import models

# Create your models here.
class Qr(models.Model):
    qr_id = models.AutoField(primary_key=True)
    b_id = models.IntegerField()
    atm_id = models.IntegerField()
    qr = models.CharField(max_length=25)

    class Meta:
        managed = False
        db_table = 'qr'
