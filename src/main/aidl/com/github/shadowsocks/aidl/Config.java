package com.github.shadowsocks.aidl;

import android.os.Parcel;
import android.os.Parcelable;

public class Config implements Parcelable {

  public boolean isGlobalProxy = true;
  public boolean isGFWList = true;
  public boolean isBypassApps = false;
  public boolean isTrafficStat = false;
  public boolean isUdpDns = false;

  public String profileName = "Untitled";
  public String proxy = "127.0.0.1";
  public String sitekey = "null";
  public String route = "all";
  public String customDNS = "10.202.68.73,10.10.0.21";
  public String customDNS_URL = ".cc98.org,.cn,.zjuqsc.com,.myqsc.com,.nexushd.org,.senorsen.com,.hlyue.com,.xsensen.me,.izju.so";

  public String encMethod = "rc4";
  public String proxiedAppString = "";

  public int remotePort = 1984;
  public int localPort = 1080;

  public static final Parcelable.Creator<Config> CREATOR = new Parcelable.Creator<Config>() {
    public Config createFromParcel(Parcel in) {
      return new Config(in);
    }

    public Config[] newArray(int size) {
      return new Config[size];
    }
  };

  public Config(boolean isGlobalProxy, boolean isGFWList, boolean isBypassApps,
      boolean isTrafficStat, boolean isUdpDns, String profileName, String proxy, String sitekey,
      String encMethod, String proxiedAppString, String route, String customDNS, String customDNS_URL, int remotePort, int localPort) {
    this.isGlobalProxy = isGlobalProxy;
    this.isGFWList = isGFWList;
    this.isBypassApps = isBypassApps;
    this.isTrafficStat = isTrafficStat;
    this.isUdpDns = isUdpDns;
    this.profileName = profileName;
    this.proxy = proxy;
    this.sitekey = sitekey;
    this.encMethod = encMethod;
    this.proxiedAppString = proxiedAppString;
    this.route = route;
    this.customDNS = customDNS;
    this.customDNS_URL = customDNS_URL;
    this.remotePort = remotePort;
    this.localPort = localPort;
  }

  private Config(Parcel in) {
    readFromParcel(in);
  }

  public void readFromParcel(Parcel in) {
    isGlobalProxy = in.readInt() == 1;
    isGFWList = in.readInt() == 1;
    isBypassApps = in.readInt() == 1;
    isTrafficStat = in.readInt() == 1;
    isUdpDns = in.readInt() == 1;
    profileName = in.readString();
    proxy = in.readString();
    sitekey = in.readString();
    encMethod = in.readString();
    proxiedAppString = in.readString();
    route = in.readString();
    customDNS = in.readString();
    customDNS_URL = in.readString();
    remotePort = in.readInt();
    localPort = in.readInt();
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel out, int flags) {
    out.writeInt(isGlobalProxy ? 1 : 0);
    out.writeInt(isGFWList ? 1 : 0);
    out.writeInt(isBypassApps ? 1 : 0);
    out.writeInt(isTrafficStat ? 1 : 0);
    out.writeInt(isUdpDns ? 1 : 0);
    out.writeString(profileName);
    out.writeString(proxy);
    out.writeString(sitekey);
    out.writeString(encMethod);
    out.writeString(proxiedAppString);
    out.writeString(route);
    out.writeString(customDNS);
    out.writeString(customDNS_URL);
    out.writeInt(remotePort);
    out.writeInt(localPort);
  }
}
