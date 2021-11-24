from django.db import models

# Create your models here.
class ReplyToBank(models.Model):
    rb_id = models.AutoField(primary_key=True)
    ca_id = models.IntegerField()
    reply = models.CharField(max_length=25)
    date = models.DateField()
    time = models.TimeField()

    class Meta:
        managed = False
        db_table = 'reply_to_bank'
