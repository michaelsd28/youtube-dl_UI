
import time
import random

from sqlalchemy import Float


strExample = """
[youtube] 8KFQx-mc2Ao: Downloading webpage
[download] Destination: 'So you won't take down lies' - Alexandria Ocasio-Cortez challenges Facebook CEO-8KFQx-mc2Ao.mp4

[download]   0.0% of 13.22MiB at 634.83KiB/s ETA 00:21
[download]   0.0% of 13.22MiB at  1.60MiB/s ETA 00:08
[download]   0.1% of 13.22MiB at 31.49KiB/s ETA 07:09
[download]   0.1% of 13.22MiB at 67.38KiB/s ETA 03:20
[download]   0.2% of 13.22MiB at 73.05KiB/s ETA 03:04
[download]   0.5% of 13.22MiB at 70.84KiB/s ETA 03:10
[download]   0.9% of 13.22MiB at 66.14KiB/s ETA 03:22
"""






# increase data values avery seconds
def increaseDataValues():
    percentageYTL:Float = 0.0
    dataYTL:Float = 0.0
    speedYTL:Float = 0.0
    etaYTL:int = 10
    etaS:int = 20
    beforeDownload = """
    [youtube] DKjFn5LIuCA: Downloading webpage
    [download] Resuming download at byte 64512
    [download] Destination: La Manatí Juanita En Una Isla Salvaje [Editorial] _ Antinoti-DKjFn5LIuCA.mp4
    """



    dataYTL = round(random.uniform(1, 800), 2)
    percentageYTL = round(random.uniform(1, 100), 2)
    speedYTL = round(random.uniform(10, 20), 2)
    etaYTL = random.randint(10, 59)
    downloadROW:str = f"{beforeDownload} \n  {percentageYTL}% of {dataYTL}MiB at {speedYTL}KiB/s ETA {etaYTL}:{etaS}"
    print(downloadROW)
    time.sleep(1)
    dataYTL = round(random.uniform(1, 800), 2)
    percentageYTL = round(random.uniform(1, 100), 2)
    speedYTL = round(random.uniform(10, 20), 2)
    etaYTL = random.randint(10, 59)
    downloadROW:str = f"{beforeDownload} \n  {percentageYTL}% of {dataYTL}MiB at {speedYTL}KiB/s ETA {etaYTL}:{etaS}"
    print(downloadROW)
    time.sleep(1)
    dataYTL = round(random.uniform(1, 800), 2)
    percentageYTL = round(random.uniform(1, 100), 2)
    speedYTL = round(random.uniform(10, 20), 2)
    etaYTL = random.randint(10, 59)
    downloadROW:str = f"{beforeDownload} \n  {percentageYTL}% of {dataYTL}MiB at {speedYTL}KiB/s ETA {etaYTL}:{etaS}"
    print(downloadROW)
    time.sleep(1)


    

    
    
increaseDataValues()
    



