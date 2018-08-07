package in.co.kani.kafka;

import java.util.List;

public class KaniProtoMO {

	private String enabled;
	private List<String> wpa;
	private List<String> authentication;
	private List<String> ciphers;
	private String phy;
	private String ssid;
	private String bssid;
	private String country;
	private String mode;
	private String channel;
	private String frequency;
	private String frequencyOffset;
	private String txpower;
	private String txpowerOffset;
	private String quality;
	private String qualityMax;
	private String noise;
	private String signal;
	private String bitrate;

	public String isEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	public List<String> getWpa() {
		return wpa;
	}
	public void setWpa(List<String> wpa) {
		this.wpa = wpa;
	}
	public List<String> getAuthentication() {
		return authentication;
	}
	public void setAuthentication(List<String> authentication) {
		this.authentication = authentication;
	}
	public List<String> getCiphers() {
		return ciphers;
	}
	public void setCiphers(List<String> ciphers) {
		this.ciphers = ciphers;
	}
	public String getPhy() {
		return phy;
	}
	public void setPhy(String phy) {
		this.phy = phy;
	}
	public String getSsid() {
		return ssid;
	}
	public void setSsid(String ssid) {
		this.ssid = ssid;
	}
	public String getBssid() {
		return bssid;
	}
	public void setBssid(String bssid) {
		this.bssid = bssid;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public String getFrequencyOffset() {
		return frequencyOffset;
	}
	public void setFrequencyOffset(String frequencyOffset) {
		this.frequencyOffset = frequencyOffset;
	}
	public String getTxpower() {
		return txpower;
	}
	public void setTxpower(String txpower) {
		this.txpower = txpower;
	}
	public String getTxpowerOffset() {
		return txpowerOffset;
	}
	public void setTxpowerOffset(String txpowerOffset) {
		this.txpowerOffset = txpowerOffset;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	public String getQualityMax() {
		return qualityMax;
	}
	public void setQualityMax(String qualityMax) {
		this.qualityMax = qualityMax;
	}
	public String getNoise() {
		return noise;
	}
	public void setNoise(String noise) {
		this.noise = noise;
	}
	public String getSignal() {
		return signal;
	}
	public void setSignal(String signal) {
		this.signal = signal;
	}
	public String getBitrate() {
		return bitrate;
	}
	public void setBitrate(String bitrate) {
		this.bitrate = bitrate;
	}
	

}
