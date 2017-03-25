<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

use Illuminate\Http\Response;

use App\User;

use DB;

use App\Event;

class UserController extends Controller
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
                
        $statuscode = "500";
         $apimsg = "Error Occurred";
         $apierror =   false;
         $registration = "";

       if(isset($_POST['user_id']))
        {
            $user_id = strip_tags(trim($_POST['user_id']));
          
        }
        else
        {
            $apierror  = true;
            $apimsg = "Please Enter event_id";   
        }

       if(isset($_POST['event_id']))
        {
            $event_id = strip_tags(trim($_POST['event_id']));
          
        }
        else
        {
            $apierror  = true;
            $apimsg = "Please Enter event_id";   
        }

         if(isset($_POST['Qr_code']))
        {
            $Qrcode = strip_tags(trim($_POST['Qr_code']));
          
        }
        else
        {
            $apierror  = true;
            $apimsg = "Please Enter Q-r_code";   
        }

         if(isset($_POST['email']))
        {
            $email = strip_tags(trim($_POST['email']));
          
        }
        else
        {
            $apierror  = true;
            $apimsg = "Please Enter email";   
        }

         if(isset($_POST['fullname']))
        {
            $fullname = strip_tags(trim($_POST['fullname']));
          
        }
        else
        {
            $apierror  = true;
            $apimsg = "Please Enter fullname";   
        }


          if(isset($_POST['status']))
        {
            $status = strip_tags(trim($_POST['status']));
          
        }
        else
        {
            $apierror  = true;
            $apimsg = "Please Enter status";   
        }

          if(isset($_POST['mobile_no']))
        {
            $mobile_no = strip_tags(trim($_POST['mobile_no']));
          
        }
        else
        {
            $apierror  = true;
            $apimsg = "Please Enter mobile_no";   
        } 


          if(isset($_POST['team_name']))
        {
            $team_name = strip_tags(trim($_POST['team_name']));
          
        }
        else
        {
            $apierror  = true;
            $apimsg = "Please Enter team_name";   
        }

        if(isset($_POST['no_of_members']))
        {
            $no_of_members = strip_tags(trim($_POST['no_of_members']));
          
        }
        else
        {
            $apierror  = true;
            $apimsg = "Please Enter no_of_members";   
        }            


         if (!Event::where('event_id', '=',$event_id)->exists()) 
            {    
               
                 $apierror  = true;
                 $statuscode="400";
                 $apimsg ="Organisation does not exits";   
                                 
            }
            
         $result=DB::insert('insert into user (event_id,Qr_code,email,fullname,status,mobile_no,team_name,no_of_members) values(?,?,?,?,?,?,?,?)' ,array($event_id,$Qrcode,$email,$fullname,$status,$mobile_no,$team_name,$no_of_members));
        
       // $result=DB::insert('insert into login (email,password,usertype) values(?,?,?,?)' ,array($email,$password,$usertype));
          

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
    public function attend(Request $request)
    {
             if(isset($_POST['Qr_code']))
             {
                 $qrcode = strip_tags(trim($_POST['Qr_code']));
             }

             else
             {
                $apierror  = true;
                $apimsg = "Please Enter no_of_members";
                echo $apimsg;
             }
              
              $this->validate($request,[
          //  'email'=>'required|email|unique:registration',
            'mobileno' =>  'required|regex:/^(\+\d{1,3}[- ]?)?\d{10}$/'
          ]);

              if (!Registration::where('event_id', '=',$event_id)->exists()) 
            {    
               
                 $apierror  = true;
                 $statuscode="400";
                 $apimsg =" Event_id does not exits";
                 echo $apimsg;   
                                 
            }

          

            $result = DB::select("select * from user where Qr_code= '$qrcode'");

            return response()->json($result);
    }


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
           
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
      {

        
      }
}
