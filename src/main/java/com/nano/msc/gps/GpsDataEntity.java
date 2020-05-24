package com.nano.msc.gps;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.nano.msc.common.converter.LocalDateTimeConverter;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: nano
 * @time: 2020/5/16 13:28
 */

@DynamicInsert
@DynamicUpdate
@Entity
@Data
@NoArgsConstructor
@Table(name = "gps_data")
public class GpsDataEntity implements Serializable {

	private static final long serialVersionUID = 233410313766289238L;
	/**
	 * 自动增长ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_id")
	private Integer id;


	private String longitude;

	private String latitude;

	private String altitude;

	private String speed;


	private Integer bdVisible;

	private Integer gpsVisible;

	private Integer validNumber;

	private String locateMode;



	/**
	 * 数据创建时间
	 */
	@JsonSerialize(using = LocalDateTimeConverter.class)
	@Column(name = "gmt_create")
	@ApiModelProperty(value = "创建时间")
	@CreationTimestamp
	private LocalDateTime gmtCreate;

	/**
	 * 数据修改时间
	 */
	@JsonSerialize(using = LocalDateTimeConverter.class)
	@Column(name = "gmt_modified")
	@ApiModelProperty(value = "更新时间")
	@UpdateTimestamp
	private LocalDateTime gmtModified;


}
