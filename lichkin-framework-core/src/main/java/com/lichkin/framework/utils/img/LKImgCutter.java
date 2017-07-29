package com.lichkin.framework.utils.img;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import com.lichkin.framework.utils.file.LKFileUtils;

/**
 * 图像裁剪工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKImgCutter {

	/**
	 * 裁剪图片
	 * @param sourceFileSteam 源文件流
	 * @param sourceFileName 源文件名
	 * @param targetFilePath 裁剪后的图片路径
	 * @param x 左上角的x轴坐标
	 * @param y 左上角的y轴坐标
	 * @param width 裁剪选择宽度
	 * @param height 裁剪选择高度
	 * @throws IOException 绘制图像时可能抛出异常
	 */
	public static void cut(final InputStream sourceFileSteam, final String sourceFileName, final String targetFilePath, final int x, final int y, final int width, final int height) throws IOException {
		final BufferedImage targetImg = new BufferedImage(width, height, BufferedImage.TYPE_USHORT_555_RGB);
		final Graphics g = targetImg.getGraphics();
		g.drawImage(Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(ImageIO.read(sourceFileSteam).getSource(), new CropImageFilter(x, y, width, height))), 0, 0, null);
		g.dispose();
		ImageIO.write(targetImg, sourceFileName.substring(sourceFileName.lastIndexOf(".") + 1), LKFileUtils.createFile(targetFilePath));
	}

}
