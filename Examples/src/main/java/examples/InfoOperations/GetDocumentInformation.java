package examples.InfoOperations;

import com.groupdocs.cloud.metadata.api.InfoApi;
import com.groupdocs.cloud.metadata.client.ApiException;
import com.groupdocs.cloud.metadata.model.FileInfo;
import com.groupdocs.cloud.metadata.model.InfoOptions;
import com.groupdocs.cloud.metadata.model.InfoResult;
import com.groupdocs.cloud.metadata.model.requests.GetInfoRequest;

import examples.Common;

/**
 * This example demonstrates how to obtain document file information.
 */
public class GetDocumentInformation {

	public static void main(String[] args) {

		InfoApi apiInstance = new InfoApi(Common.GetConfiguration());

		try {
			FileInfo fileInfo = new FileInfo();
			fileInfo.setFilePath("documents/input.docx");
			fileInfo.setStorageName(Common.MyStorage);
			InfoOptions options = new InfoOptions();
			options.setFileInfo(fileInfo);
			GetInfoRequest request = new GetInfoRequest(options);
			InfoResult response = apiInstance.getInfo(request);

			System.out.println("InfoResult.PageCount: " + response.getPageCount());
		} catch (ApiException e) {
			System.err.println("Exception while calling InfoApi:");
			e.printStackTrace();
		}
	}
}