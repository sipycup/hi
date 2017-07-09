package com.camshare.camfrog.app.authentication.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.camshare.camfrog.app.authentication.h;
import com.camshare.camfrog.app.d.n;
import com.facebook.CallbackManager;
import com.facebook.CallbackManager.Factory;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import java.util.List;

public class a
  extends com.camshare.camfrog.app.authentication.c
  implements h
{
  private static final int c = 2;
  private static final String d = "SIGN_IN_FB_SUGGESTED_NICKS_DIALOG_TAG";
  private d e;
  private b f;
  private f g;
  private com.camshare.camfrog.app.authentication.f h;
  private CallbackManager i;
  
  public void a_()
  {
    this.g.c();
  }
  
  public void b(@NonNull String paramString)
  {
    if ("connecting_dialog".equalsIgnoreCase(paramString)) {
      this.g.f();
    }
  }
  
  public void onActivityCreated(@Nullable Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.f = ((a.b.a)getActivity()).a();
    this.f.a(this);
    this.i = CallbackManager.Factory.create();
    LoginManager.getInstance().registerCallback(this.i, new c());
    d.a(this.e).setOnClickListener(b.a(this));
    d.b(this.e).setOnClickListener(c.a(this));
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.i.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    paramContext = com.camshare.camfrog.app.c.c.a();
    this.g = new f(paramContext.t(), paramContext.f(), new a(null));
  }
  
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130903137, paramViewGroup, false);
    this.e = new d(paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (this.f != null) {
      this.f.a(null);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.h != null) {
      this.h.dismiss();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    this.g.b();
  }
  
  public void onStop()
  {
    this.g.q();
    super.onStop();
  }
  
  private class a
    implements f.a
  {
    private a() {}
    
    public void a()
    {
      a.d.c(a.a(a.this)).setVisibility(8);
    }
    
    public void a(@NonNull String paramString)
    {
      a.d.c(a.a(a.this)).setVisibility(0);
      a.d.d(a.a(a.this)).setText(paramString);
    }
    
    public void a(@NonNull List<String> paramList)
    {
      LoginManager.getInstance().logInWithReadPermissions(a.this, paramList);
    }
    
    public void a(@NonNull String[] paramArrayOfString)
    {
      a.a(a.this, com.camshare.camfrog.app.authentication.f.a(paramArrayOfString));
      a.b(a.this).setTargetFragment(a.this, 2);
      paramArrayOfString = a.b(a.this);
      f localf = a.c(a.this);
      localf.getClass();
      paramArrayOfString.a(d.a(localf));
      a.b(a.this).show(a.this.getFragmentManager(), "SIGN_IN_FB_SUGGESTED_NICKS_DIALOG_TAG");
      paramArrayOfString = a.b(a.this);
      localf = a.c(a.this);
      localf.getClass();
      paramArrayOfString.a(e.a(localf));
    }
    
    public void b()
    {
      a.this.a();
    }
    
    public void c()
    {
      a.a(a.this, "connecting_dialog", 2131296751, true);
    }
    
    public void d()
    {
      a.a(a.this, "connecting_dialog");
    }
    
    public void e()
    {
      LoginManager.getInstance().logOut();
    }
    
    public void f()
    {
      a.d(a.this).a();
    }
    
    public void g()
    {
      a.d(a.this).b();
    }
    
    @NonNull
    public Context getContext()
    {
      return a.this.getContext();
    }
  }
  
  public static abstract interface b
  {
    public abstract void a();
    
    public abstract void a(@Nullable h paramh);
    
    public abstract void b();
    
    public static abstract interface a
    {
      @NonNull
      public abstract a.b a();
    }
  }
  
  public class c
    implements FacebookCallback<LoginResult>
  {
    public c() {}
    
    public void a(LoginResult paramLoginResult)
    {
      a.c(a.this).a(paramLoginResult);
    }
    
    public void onCancel() {}
    
    public void onError(FacebookException paramFacebookException)
    {
      a.c(a.this).h();
    }
  }
  
  private class d
  {
    private final LinearLayout b;
    private final TextView c;
    private final LinearLayout d;
    private final Button e;
    
    public d(@NonNull View paramView)
    {
      this.b = ((LinearLayout)n.a(paramView, 2131755308));
      this.c = ((TextView)n.a(paramView, 2131755309));
      this.d = ((LinearLayout)n.a(paramView, 2131755310));
      this.e = ((Button)n.a(paramView, 2131755312));
    }
  }
}
