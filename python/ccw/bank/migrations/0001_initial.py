# Generated by Django 3.1.6 on 2021-03-25 10:26

from django.db import migrations, models


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='Bank',
            fields=[
                ('b_id', models.AutoField(primary_key=True, serialize=False)),
                ('l_id', models.IntegerField()),
                ('bank_name', models.CharField(max_length=25)),
                ('address', models.CharField(max_length=50)),
                ('reg_no', models.CharField(max_length=20)),
                ('ifsc_code', models.CharField(max_length=20)),
                ('email', models.CharField(max_length=25)),
                ('phone_number', models.CharField(max_length=10)),
                ('status', models.CharField(max_length=100)),
            ],
            options={
                'db_table': 'bank',
                'managed': False,
            },
        ),
    ]