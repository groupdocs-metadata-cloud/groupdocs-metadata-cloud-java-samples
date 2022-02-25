package examples;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.groupdocs.cloud.metadata.api.FileApi;
import com.groupdocs.cloud.metadata.client.ApiException;
import com.groupdocs.cloud.metadata.model.requests.UploadFileRequest;

import examples.Common;

public class UploadResources {
	public static FileApi fileApi = new FileApi(Common.GetConfiguration());

	public static String resourcesPath = Paths.get("Examples\\src\\main\\resources").toAbsolutePath().toString();

	public static void main(String[] args) {
		try {
			System.out.println("File Upload Processing: "+ resourcesPath);

			uploadFiles(resourcesPath);

			System.out.println("File Upload Process End");
		} catch (ApiException e) {
			System.err.println("Exception while file uploading:");
			e.printStackTrace();
		}
	}

	public static void uploadFiles(String path) throws ApiException {
		File directory = new File(path);

		File[] files = directory.listFiles();
		for (File file : files) {
			String relativePath = getRelativePath(file.getAbsolutePath(), resourcesPath);
			if (file.isFile()) {
				uploadFile(file, relativePath);
			} else if (file.isDirectory()) {
				uploadFiles(file.getAbsolutePath().toString());
			}
		}
	}

	public static String getRelativePath(String absolutePath, String basePath) {
		Path absolute = Paths.get(absolutePath);
		Path base = Paths.get(basePath);
		Path relative = base.relativize(absolute);

		return relative.toString();
	}

	public static void uploadFile(File file, String relativePath) throws ApiException {
		String filePath = relativePath.replace("\\", "/");
		System.out.println("Uploading File: " + filePath);
		UploadFileRequest request = new UploadFileRequest(filePath, file, Common.MyStorage);
		fileApi.uploadFileWithHttpInfo(request);
	}
}
