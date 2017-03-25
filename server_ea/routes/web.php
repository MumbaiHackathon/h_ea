<?php

/*
|--------------------------------------------------------------------------
| Application Routes
|--------------------------------------------------------------------------
|
| Here is where you can register all of the routes for an application.
| It is a breeze. Simply tell Lumen the URIs it should respond to
| and give it the Closure to call when that URI is requested.
|
*/
/*
$app->get('/', function () use ($app) {
    return $app->version();
});

*/

$app->group(['prefix'=>'api/v1'],function($app)
{
     $app->get('','EventController@index');              //shows all the events

     $app->post('/store','LoginController@store');         //insert the data in the login table

     $app->post('/login','LoginController@login');        // checking the login

     $app->post('','EventController@store');             //insert the data in the event

     $app->post('/user','UserController@store');       //insert into user

     $app->post('/attend','UserController@attend');      // rertriving data from user
});
