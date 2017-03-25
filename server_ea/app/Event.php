<?php

namespace App;

use Illuminate\Auth\Authenticatable;
use Laravel\Lumen\Auth\Authorizable;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Contracts\Auth\Authenticatable as AuthenticatableContract;
use Illuminate\Contracts\Auth\Access\Authorizable as AuthorizableContract;

class  Event extends Model 
{
    

    /**
     * The attributes that are mass assignable.
     *
     * @var array
     */

    protected $table='event';
    
    //public $primaryKey ='event_id';

    protected $fillable = [
        'dateTime','event_name', 'venue','event_type','details','email_id'
    ];

    /**
     * The attributes excluded from the model's JSON form.
     *
     * @var array
     */
    protected $hidden = [
        'password',
    ];
}
