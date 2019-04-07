package com.bumptech.glide.load;

/**
 * Indicates the origin of some retrieved data.
 */
public enum DataSource {
  /**
   * Indicates data was probably retrieved locally from the device, although it may have been
   * obtained through a content provider that may have obtained the data from a remote source.
   * 从本地获取的数据
   */
  LOCAL,
  /**
   * Indicates data was retrieved from a remote source other than the device.
   * 从远端拉到的数据
   */
  REMOTE,
  /**
   * Indicates data was retrieved unmodified from the on device cache.
   * 磁盘中存的原始数据
   */
  DATA_DISK_CACHE,
  /**
   * Indicates data was retrieved from modified content in the on device cache.
   * 磁盘中存的经过修改的数据
   */
  RESOURCE_DISK_CACHE,
  /**
   * Indicates data was retrieved from the in memory cache.
   * 从内存中直接读取
   */
  MEMORY_CACHE,
}
