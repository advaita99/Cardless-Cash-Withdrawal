# Generated by Django 3.1.6 on 2021-03-25 10:26

from django.db import migrations, models


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='ReplyToBank',
            fields=[
                ('rb_id', models.AutoField(primary_key=True, serialize=False)),
                ('ca_id', models.IntegerField()),
                ('reply', models.CharField(max_length=25)),
                ('date', models.DateField()),
                ('time', models.TimeField()),
            ],
            options={
                'db_table': 'reply_to_bank',
                'managed': False,
            },
        ),
    ]
