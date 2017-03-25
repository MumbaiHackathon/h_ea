<?php

namespace App\Http\Controllers;

use Illuminate\Support\Facades\Cache;

use Illuminate\Http\Request;

use App\Event;

use App\Organisation;

use DB;

class EventController extends Controller
{


    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
          
           
        $dataInput=Event::all();
        // echo "Hoi";
        return response()->json($dataInput);
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
         $statuscode = "500";
         $apimsg = "Error Occurred";
         $apierror =   false;
         $registration = "";

       if(isset($_POST['id']))
        {
            $id = strip_tags(trim($_POST['id']));
          
        }
        else
        {
            $apierror  = true;
            $apimsg = "Please Enter event_name";   
        }

         if(isset($_POST['event_name']))
        {
            $event_name = strip_tags(trim($_POST['event_name']));
          
        }
        else
        {
            $apierror  = true;
            $apimsg = "Please Enter event_name";   
        }

        if(isset($_POST['venue']))
        {
            $venue = strip_tags(trim($_POST['venue']));
        }
        else
        {
            $apierror  = true;
            $apimsg = "Please Enter venue";   
        }


                if(isset($_POST['details']))
        {
            $details = strip_tags(trim($_POST['details']));

        }
        else
        {
            $apierror  = true;
            $apimsg = "Please Enter details";   
        }



          if(isset($_POST['email_id']))
        {
            $email = strip_tags(trim($_POST['email_id']));
        }
        else
        {
            $apierror  = true;
            $apimsg = "Please Enter email";   
        }

        if(isset($_POST['event_date']))
          {
              $date = date('y-m-d',strtotime($_POST['event_date']));
          }

          else 
          {

              $apierror = true;
              $apimsg="Enter the date";

          }

          
          if(isset($_POST['tym']))
          {
               $time = strip_tags(trim($_POST['tym']));
          }

          else 
          {

              $apierror = true;
              $apimsg="Enter the date";

          }

          if(isset($_POST['max_team']))
          {
               $max_team = strip_tags(trim($_POST['max_team']));
          }

          else 
          {

              $apierror = true;
              $apimsg="Enter the max_team";

          }
  
  
       
            $this->validate($request,[
            'email_id'=>'required|email|unique:Event',
          
          ]);
            
            

         
     

        if (!Organisation::where('id', '=',$id)->exists()) 
            {    
               
                 $apierror  = true;
                 $statuscode="400";
                 $apimsg ="Organisation does not exits";   
                                 
            }


        
       

         //Add RECORds to database of child db
     $result=DB::insert('insert into event (id,event_name,venue,details,email_id,event_date,tym,max_team) values(?,?,?,?,?,?,?,?)' ,array($id,$event_name,$venue,$details,$email,$date,$time,$max_team)); 
            
            if($result == 1)
            {
                $xyz= DB::select("select * from event where email_id='$email'"); 
                return response()->json($xyz);
            }

         
        }
    
    
    
     

    //return json


    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {

        //$data=Appointment::findorFail($id);

        //return response()->json($data);

    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function edit($id)
    {
        
    }

    /**0
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
