/*
 * DRACOON API
 * REST Web Services for DRACOON<br>built at: 2020-10-14 12:14:23<br><br>This page provides an overview of all available and documented DRACOON APIs, which are grouped by tags.<br>Each tag provides a collection of APIs that are intended for a specific area of the DRACOON.<br><br><a title='Developer Information' href='https://developer.dracoon.com'>Developer Information</a>&emsp;&emsp;<a title='Get SDKs on GitHub' href='https://github.com/dracoon'>Get SDKs on GitHub</a><br><br><a title='Terms of service' href='https://www.dracoon.com/terms/general-terms-and-conditions/'>Terms of service</a>
 *
 * OpenAPI spec version: 4.24.0-SNAPSHOT
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package ch.cyberduck.core.sds.io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * Syslog settings
 */
@Schema(description = "Syslog settings")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-10-15T15:35:23.522373+02:00[Europe/Zurich]")
public class SyslogConfig {
  @JsonProperty("enabled")
  private Boolean enabled = null;

  @JsonProperty("host")
  private String host = null;

  @JsonProperty("port")
  private Integer port = null;

  /**
   * Protocol to connect to syslog server
   */
  public enum ProtocolEnum {
    TCP("TCP"),
    UDP("UDP");

    private String value;

    ProtocolEnum(String value) {
      this.value = value;
    }
    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    @JsonCreator
    public static ProtocolEnum fromValue(String text) {
      for (ProtocolEnum b : ProtocolEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("protocol")
  private ProtocolEnum protocol = null;

  @JsonProperty("logIpEnabled")
  private Boolean logIpEnabled = null;

  public SyslogConfig enabled(Boolean enabled) {
    this.enabled = enabled;
    return this;
  }

   /**
   * Is syslog enabled?
   * @return enabled
  **/
  @Schema(description = "Is syslog enabled?")
  public Boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  public SyslogConfig host(String host) {
    this.host = host;
    return this;
  }

   /**
   * Syslog server (IP or FQDN)
   * @return host
  **/
  @Schema(description = "Syslog server (IP or FQDN)")
  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  public SyslogConfig port(Integer port) {
    this.port = port;
    return this;
  }

   /**
   * Syslog server port
   * @return port
  **/
  @Schema(description = "Syslog server port")
  public Integer getPort() {
    return port;
  }

  public void setPort(Integer port) {
    this.port = port;
  }

  public SyslogConfig protocol(ProtocolEnum protocol) {
    this.protocol = protocol;
    return this;
  }

   /**
   * Protocol to connect to syslog server
   * @return protocol
  **/
  @Schema(description = "Protocol to connect to syslog server")
  public ProtocolEnum getProtocol() {
    return protocol;
  }

  public void setProtocol(ProtocolEnum protocol) {
    this.protocol = protocol;
  }

  public SyslogConfig logIpEnabled(Boolean logIpEnabled) {
    this.logIpEnabled = logIpEnabled;
    return this;
  }

   /**
   * Determines whether user’s IP address is logged.
   * @return logIpEnabled
  **/
  @Schema(description = "Determines whether user’s IP address is logged.")
  public Boolean isLogIpEnabled() {
    return logIpEnabled;
  }

  public void setLogIpEnabled(Boolean logIpEnabled) {
    this.logIpEnabled = logIpEnabled;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SyslogConfig syslogConfig = (SyslogConfig) o;
    return Objects.equals(this.enabled, syslogConfig.enabled) &&
        Objects.equals(this.host, syslogConfig.host) &&
        Objects.equals(this.port, syslogConfig.port) &&
        Objects.equals(this.protocol, syslogConfig.protocol) &&
        Objects.equals(this.logIpEnabled, syslogConfig.logIpEnabled);
  }

  @Override
  public int hashCode() {
    return Objects.hash(enabled, host, port, protocol, logIpEnabled);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SyslogConfig {\n");
    
    sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
    sb.append("    host: ").append(toIndentedString(host)).append("\n");
    sb.append("    port: ").append(toIndentedString(port)).append("\n");
    sb.append("    protocol: ").append(toIndentedString(protocol)).append("\n");
    sb.append("    logIpEnabled: ").append(toIndentedString(logIpEnabled)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
