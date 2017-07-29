package com.lichkin.framework.utils.img;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import com.lichkin.framework.bases.statics.LKStringStatics;
import com.lichkin.framework.utils.file.LKFileUtils;

/**
 * 图片放大器
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKImgZoomer {

	/**
	 * 缩放图片（等比例缩放）
	 * @param sourceFileSteam 源图片输入流
	 * @param sourceFileName 源图片文件名
	 * @param targetFilePath 缩放后的图片路径
	 * @param scale 缩放比例，大于1时为放大，小于1时为缩小。
	 * @return 缩放后的图片文件
	 * @throws IOException 绘制图像时可能抛出异常
	 */
	public static File zoom(final InputStream sourceFileSteam, final String sourceFileName, final String targetFilePath, final float scale) throws IOException {
		final BufferedImage sourceImg = ImageIO.read(sourceFileSteam); // 读入文件
		final int width = (int) (sourceImg.getWidth() * scale); // 得到源图宽
		final int height = (int) (sourceImg.getHeight() * scale); // 得到源图长
		final BufferedImage targetImg = new BufferedImage(width, height, BufferedImage.TYPE_USHORT_555_RGB);
		final Graphics g = targetImg.getGraphics();
		g.drawImage(sourceImg.getScaledInstance(width, height, Image.SCALE_DEFAULT), 0, 0, null); // 绘制缩小后的图
		g.dispose();
		final File targetFile = LKFileUtils.createFile(targetFilePath);
		ImageIO.write(targetImg, sourceFileName.substring(sourceFileName.lastIndexOf(LKStringStatics.STR_DOT) + 1), targetFile);// 输出到文件流
		return targetFile;
	}

}
