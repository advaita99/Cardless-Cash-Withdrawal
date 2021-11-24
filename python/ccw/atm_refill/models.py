from django.db import models

# Create your models here.
class AtmRefill(models.Model):
    ref_id = models.AutoField(primary_key=True)
    atm_id = models.IntegerField()
    amount = models.IntegerField()
    date = models.DateField()
    time = models.TimeField()

    class Meta:
        managed = False
        db_table = 'atm_refill'


