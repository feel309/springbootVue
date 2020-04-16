const recorderContainer = document.getElementById("jsRecordContainer");
const recordBtn = document.getElementById("jsRecordBtn");
const videoPreview = document.getElementById("jsVideoPreview"); // upload.pug에 있는 video 객체 가져옴.

let streamObject;
let videoRecorder;

const handleVideoData = event => {
  // 우리는 blob으로 된 비디오 영상 다운로드.
  const { data: videoFile } = event;
  const link = document.createElement("a");
  link.href = URL.createObjectURL(videoFile); // 다운로드 링크
  link.download = "recorded.webm"; // webm은 오픈 소스래.
  document.body.appendChild(link); // 링크를 html에 붙여서 
  link.click(); // 클릭하게 함.
};

const stopRecording = () => {
  videoRecorder.stop();
  recordBtn.removeEventListener("click", stopRecording);
  recordBtn.addEventListener("click", getVideo);
  recordBtn.innerHTML = "Start recording";
};

const startRecording = () => {
  videoRecorder = new MediaRecorder(streamObject); // 레코딩 하기 위해 MediaStream이 인자로 필요.
  videoRecorder.start();
  // 녹화가 멈췄을 때 dataavailable 이벤트 호출이 일어남.
  // 녹화가 멈췄을 때 전체 파일을 얻을 수 있는 이벤트. (handleVideoData 호출);
  videoRecorder.addEventListener("dataavailable", handleVideoData);
  recordBtn.addEventListener("click", stopRecording);
};

const getVideo = async () => {
  try {
    // user가 우리에게 대답할 때까지 기다리기 위해서 await 씀.
    const stream = await navigator.mediaDevices.getUserMedia({
      audio: true,
      video: { width: 1280, height: 720 }
    });
    videoPreview.srcObject = stream;
    videoPreview.muted = true;
    videoPreview.play();
    recordBtn.innerHTML = "Stop recording"; // 녹화 시작하고 클릭 다시 했을 때는 중지지 다시 시작아니므로. 
    streamObject = stream;
    startRecording();
  } catch (error) {
    recordBtn.innerHTML = "☹️ Cant record";
  } finally {
    recordBtn.removeEventListener("click", getVideo); // 녹화 시작하고 클릭 다시 했을 때는 중지지 다시 시작아니므로. 
  }
};

function init() {
  recordBtn.addEventListener("click", getVideo);
}

if (recorderContainer) {
  init();
}