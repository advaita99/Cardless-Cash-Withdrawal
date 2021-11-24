from django.db import models

# Create your models here.

class Reply(models.Model):
    r_id = models.AutoField(primary_key=True)
    c_id = models.IntegerField()
    date = models.DateField()
    time = models.TimeField()
    reply = models.CharField(max_length=50)

    class Meta:
        managed = False
        db_table = 'reply'
