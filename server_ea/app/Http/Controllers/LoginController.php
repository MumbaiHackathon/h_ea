<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

use Illuminate\Http\Response;

use App\Login;

use DB;

class LoginController extends Controller
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

   

   
         if(isset($_POST['email']))
        {
            $email = strip_tags(trim($_POST['email']));
          
        }
        else
        {
            $apierror  = true;
            $apimsg = "Please Enter email";
            echo $apimsg;   
        }

        if(isset($_POST['password']))
        {
            $password = strip_tags(trim($_POST['password']));
        }
        else
        {
            $apierror  = true;
            $apimsg = "Please Enter password";
            echo $apimsg ;  
        }

        if(isset($_POST['usertype']))
        {
            $usertype = strip_tags(trim($_POST['usertype']));
        }
        else
        {
            $apierror  = true;
            $apimsg = "Please Enter password";
            echo $apimsg;   
        }

         $this->validate($request,[
            'email'=>'required|email|unique:login',
            
          ]);
           
       
        

        if (Login::where('email', '=', $email)->exists()) 
             {
                 
                   $apierror  = true;
                   $statuscode="400";
                   $apimsg = "Email id alreay exists";
                   $jsondata['statuscode'] = $statuscode;
                   $jsondata['status'] = $apimsg;
                 exit();   
              }

   $result=DB::insert('insert into login (email,password,usertype) values(?,?,?,?)' ,array($email,$password,$usertype)); 
  

          
    
         
   return response()->json($result);
 }                                                                                                                                                                               

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */


    public function login(Request $request)
    {       

         $statuscode = "500";
         $apimsg = "Error Occurred";
         $apierror =   false;
         $registration = "";

   

   
         if(isset($_POST['email']))
        {
            $email = strip_tags(trim($_POST['email']));
          
        }
        else
        {
            $apierror  = true;
            $apimsg = "Please Enter email";   
        }

        if(isset($_POST['password']))
        {
            $password = strip_tags(trim($_POST['password']));
        }
        else
        {
            $apierror  = true;
            $apimsg = "Please Enter password";   
        }

        
          
         $result=DB::select("select * from login where email='$email' and password='$password'"); 
       
        if($result != null)
        {
            echo "login successful";
        }      

        else
        {
            echo "unsuceesfull"; 
        }
          
         
      //return response()->json($result);
           
    }


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
