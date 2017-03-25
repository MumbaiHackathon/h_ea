<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateEventTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('event', function (Blueprint $table) {
            $table->increments('event_id');
            $table->integer('id');  //organisation
            $table->string('event_name');
            $table->string('venue');
            $table->text('details');
            $table->string('email_id')->unique();
            $table->date('event_date');
            $table->string('tym');
            $table->integer('max_team');
        //    $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('event');
    }
}
