<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

use Illuminate\Http\Response;

use App\Organisation;

use DB;

class OrganisationController extends Controller
{
    public function index()
    {
       // echo "hii";
        
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        //
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
   public function store(Request $request)
   {
     // $inputdata=Registration::create($request->all());
         $statuscode = "500";
         $apimsg = "Error Occurred";
         $apierror =   false;
         $registration = "";


        

        if(isset($_POST['organisation_name']))
        {  
          
            $name = strip_tags(trim($_POST['organisation_name']));
        }

        else
        {
            $apierror  = true;
            $apimsg = "Please Enter name";   
        }              
            

        $result=DB::insert('insert into organisation (organisation_name) values(?)' ,array($name));  


        }                                                                                                                                                                               

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        //
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function edit($id)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
    {
      //      
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        //
    }
}
